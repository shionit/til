<template>
    <el-button type="text" class="signout-label" @click="signOut">Signout</el-button>
</template>

<script>
    import firebase from 'firebase'

    export default {
        name: "SubHeader",
        methods: {
            signOut: function () {
                firebase.auth().signOut().then(() => {
                    this.$router.push('/signin')
                })

            }
        }
    }
</script>

<style scoped>

</style>