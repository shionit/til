'use strict';

// アプリケーションをコントロールするモジュール
var app = require('app');
// ウィンドウを作成するモジュール
var BrowserWindow = require('browser-window');

var Tray = require('tray');
var Menu = require('menu');

// クラッシュレポート
require('crash-reporter').start();

// メインウィンドウはGCされないようグローバル宣言
var mainWindow = null;

// 全てのウィンドウが閉じたら終了
app.on('window-all-closed', function() {
    if (process.platform != 'darwin') {
        app.quit();
    }
});

// Electronの初期化完了後に実行
app.on('ready', function() {
    // メイン画面の表示。ウィンドウの幅、高さを指定できる
    mainWindow = new BrowserWindow({
        width: 500,
        height:600,
        transparent: true,
        frame: false
    });
    mainWindow.loadUrl('file://' + __dirname + '/index.html');

    // ウィンドウが閉じられたらアプリも終了
    mainWindow.on('closed', function() {
        mainWindow = null;
    });

    // メニューアイコン設定
    var appIcon = new Tray(__dirname + '/images/icon.png');
    // コンテキストメニュー追加
    var contextMenu = Menu.buildFromTemplate([
        {label: '選択メニュー１', type: 'radio'},
        {label: '選択メニュー２', type: 'radio'},
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
});
