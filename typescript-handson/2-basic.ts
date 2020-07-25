// ** Data type **

// boolean
// number
// string
// any

// ** variable **

let hoge: string = 'hoge';
let fuga: number = 999;

// constants

const PIYO: boolean = false;

// 型推論
let str = 'hoge';   // string
let num = 100;      // number
let flg = true;     // boolean
let xxx;            // any

// null / undefined

// ** array **

let arr1: string[] = ['hoge', 'fuga', 'piyo'];   // string array
let arr2: Array<number> = [1, 2, 3];             // number array
let arr3 = [10, 20, 30];                        // number array
let arr4 = [];                                  // any array

// method

arr1.push('boo');   // hoge,fuga,piyo,boo
arr1.unshift('xxx');    // xxx,hoge,fuga,piyo,boo
alert(arr1.reverse());  // boo,piyo,fuga,hoge,xxx

// index access

alert(arr1[2]); // fuga

// ** Tuple **

let tpl: [string, number, boolean] = ['hoge', 999, true];

alert(tpl[1]);  // 999

tpl[0] = 'fuga';
alert(tpl);

// ** Union **

let userId: number | string;

userId = 999;   // ok
userId = '001'; // ok
//userId = true;  // can't

if (typeof (userId) == 'string') {
    alert('string');
} else if (typeof (userId) == 'number') {
    alert('number');
} else {
    alert('other');
}

// ** Enum **

enum Color {
    RED,
    GREEN,
    BLUE
}

alert(Color.RED);   // 0
alert(Color.GREEN); // 1
alert(Color.BLUE);  // 2

enum Color2 {
    RED = 10,
    GREEN,
    BLUE
}

alert(Color2.RED);   // 10
alert(Color2.GREEN); // 11
alert(Color2.BLUE);  // 12

enum Color3 {
    RED = 10,
    GREEN = 20,
    BLUE = 30
}

alert(Color3.RED); // 10
alert(Color3.GREEN); // 20
alert(Color3.BLUE); // 30
