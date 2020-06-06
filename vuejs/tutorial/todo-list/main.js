// https://jp.vuejs.org/v2/examples/todomvc.html
var STORAGE_KEY = 'todos-vuejs-demo'
var todoStrage = {
  fetch: function () {
    var todos = JSON.parse(
      localStorage.getItem(STORAGE_KEY) || '[]'
    )
    todos.forEach(function (todo, index) {
      todo.id = index
    })
    todoStrage.uid = todos.length
    return todos
  },
  save: function (todos) {
    localStorage.setItem(STORAGE_KEY, JSON.stringify(todos))
  }
}

const app = new Vue({
  el: '#app',
  data: {
    todos: [],
    options: [
      { value: -1, label: 'all' },
      { value: 0, label: 'In Progress' },
      { value: 1, label: 'Complete' }
    ],
    current: -1
  },
  created: function () {
    this.todos = todoStrage.fetch()
  },
  methods: {
    doAdd: function (event, value) {
      var comment = this.$refs.comment
      if (!comment.value.length) {
        return
      }
      this.todos.push({
        id: todoStrage.uid++,
        comment: comment.value,
        state: 0
      })
      comment.value = ''
    },
    doChangeState: function (item) {
      item.state = item.state ? 0 : 1
    },
    doRemove: function (item) {
      var index = this.todos.indexOf(item)
      this.todos.splice(index, 1)
    }
  },
  computed: {
    computedTodos: function () {
      return this.todos.filter(function (el) {
        return this.current < 0 ? true :
          this.current === el.state
      }, this)
    },
    labels() {
      return this.options.reduce(function (a, b) {
        return Object.assign(a, { [b.value]: b.label })
      }, {})
    }
  },
  watch: {
    todos: {
      handler: function (todos) {
        todoStrage.save(todos)
      },
      deep: true
    }
  }
})
