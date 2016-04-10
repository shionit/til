var colors = document.getElementsByName('colors');

document.getElementById('save').onclick = function() {
  if (colors[0].checked) {
    localStorage['color'] = 'red';
  } else if (colors[1].checked) {
    localStorage['color'] = 'green';
  } else {
    localStorage['color'] = 'blue';
  }
}

document.body.onload = function() {
  switch(localStorage['color']) {
    case 'red':
      colors[0].checked = true;
      break;
    case 'green':
      colors[1].checked = true;
      break;
    case 'blue':
      colors[2].checked = true;
      break;
    default:
      colors[0].checked = true;
      break;
  }
}
