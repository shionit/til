// ** 条件分岐 **

// if / switch / 三項演算子

// ** Loop **

// for / for...in / for...of / while / do...while
// Array.forEach

// ** exception **

try {
    throw 'err';
} catch (e) {
    alert(e);   // err
} finally {
    // 略
}

try {
    throw 'err';
} catch {
    alert('hoge');
} finally {
    // 略
}

// ** Function **

function add(a: number, b: number): number {
    return a + b;
}
alert(add(1, 2));

// void

function shout(s: string): void {
    alert(`${s}!`);
}
shout('hoge');  // hoge!

// function literal

let hoge = function (): void {
    alert('hoge');
}
hoge(); // hoge

// arrow function

let fuga = (x: string): string => {
    return x + x;
}
alert(fuga('piyo'));

// return Tuple

function fnc(): [string, string, number] {
    return ['hoge', 'fuga', 999];
}

let tpl = fnc();
alert(tpl); // hoge,fuga,999

// ** parameter **

// nomal parameter
// default parameter

function fnc1(x: number = 1): number {
    return x + 1;
}
alert(fnc1());  // 2
alert(fnc1(10)); // 11

// optional parameter

function fnc2(x?: number): number {
    return 2 * (x === undefined ? 1 : x);
}
alert(fnc2()); // 2
alert(fnc2(10));    // 20

// 可変長引数

function fnc3(...x: number[]): number {
    let res: number = 0;
    x.forEach((i: number): void => {
        res += i;
    });
    return res;
}
alert(fnc3()); // 0
alert(fnc3(1, 2, 3));   // 6

namespace Function2 {

    // function overrode

    function fnc(x: string): string;
    function fnc(x: number, y: number): number;
    function fnc(x: boolean): void;

    // implementation

    function fnc(x: any, y?: number): any {
        if (typeof x === 'string') {
            return `${x}!`
        } else if (typeof x === 'number') {
            return x + (y === undefined ? 1 : y);
        } else {
            if (x) alert('fuga');
        }
    }

    alert(fnc('hoge'));     // hoge!
    alert(fnc(1, 2));       // 3
    fnc(true);              // fuga

    // type assertion

    let val1: any = 'abcde';
    let len1: number = (<string>val1).length;
    alert(len1);    // 5

    let val2: any = 'あいう';
    let len2: number = (val2 as string).length;
    alert(len2); //3

}
