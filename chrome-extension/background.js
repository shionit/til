chrome.browserAction.onClicked.addListener(function() {
  var color = localStorage['color'] ? localStorage['color'] : 'red';
  chrome.tabs.executeScript(null, {
    "code": "document.body.style.backgroundColor='" + color + "'"
  });
});
