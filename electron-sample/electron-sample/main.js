'use strict';

// アプリケーションをコントロールするモジュール
var app = require('app');
// ウィンドウを作成するモジュール
var BrowserWindow = require('browser-window');
var Tray = require('tray');
var Menu = require('menu');

// クラッシュレポート
require('crash-reporter').start();

// 全てのウィンドウが閉じたら終了
app.on('window-all-closed', function() {
    if (process.platform != 'darwin') {
        app.quit();
    }
});

var appIcon = null;
// Electronの初期化完了後に実行
app.on('ready', function() {
    // メニューアイコン設定
    appIcon = new Tray(__dirname + '/images/icon.png');
    // コンテキストメニュー追加
    var contextMenu = Menu.buildFromTemplate([
        {label: 'ウィンドウを非表示', type: 'radio', click: function() { appIcon.window.hide(); }},
        {label: 'ウィンドウを表示', type: 'radio', click: function() { appIcon.window.show(); }},
        {type: 'separator'},
        {label: 'サブメニュー', submenu: [
            {label: 'サブメニュー１'},
            {label: 'サブメニュー２'}
        ]},
        {label: '終了', accelerator: 'Command+Q', click: function() { app.quit(); }}
    ]);
    appIcon.setContextMenu(contextMenu);
    // アイコンにマウスオーバーした時の説明
    appIcon.setToolTip('This is sample.');

    // メイン画面はデフォルト非表示。ウィンドウの幅、高さを指定できる
    appIcon.window = new BrowserWindow({
        width: 500,
        height:500,
        transparent: true,
        frame: false,
        show: false
    });
    // ドックも非表示
    app.dock.hide();

    appIcon.window.loadUrl('file://' + __dirname + '/index.html');

    // ウィンドウが閉じられたらアプリも終了
    appIcon.window.on('closed', function() {
        appIcon.window = null;
    });
});
