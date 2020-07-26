// ** Class **
namespace MyClass {
    class Cls {
        // constructor
        constructor(private _x: number, private _y: number) {
        }

        // getter / setter
        get x(): number {
            return this._x;
        }
        set x(x: number) {
            this._x = x;
        }
        get y(): number {
            return this._y;
        }
        set y(y: number) {
            this._y = y;
        }

        // method
        calc(): void {
            alert(this._x + this._y);
        }
    }

    // using

    let cls = new Cls(1, 1);
    cls.calc(); // 2
    cls.x = 10;
    cls.y = 11;
    cls.calc(); // 21

    // ** inheritance **

    class Js {
        constructor(private name: string) {
        }

        public hello(): string {
            return 'Hello ' + this.name;
        }
    }

    // extends

    class Ts extends Js {
        constructor() {
            super("TypeScript");
        }

        // Override
        public hello(): string {
            return super.hello() + "!!!";
        }
    }

    let ts = new Ts();
    alert(ts.hello());  // Hello TypeScript!!!

    // ** abstract class **

    abstract class Human {
        abstract hello(msg: string): string;
    }

    class Man extends Human {
        public hello(msg: string): string {
            return msg + 'だぜ！';
        }
    }

    let man = new Man();
    alert(man.hello('こんにちは')); // こんにちはだぜ！
}

// ** interface **

namespace MyInterface {

    interface Human {
        name: string;
        age?: number;    // 実装任意のフィールド
        hello(msg: string): string;
    }

    class Shiro implements Human {
        constructor(public name: string) {
        }

        public hello(msg: string): string {
            return `${msg}、${this.name} です`;
        }
    }

    let shiro = new Shiro("山田");
    alert(shiro.hello('こんにちは'));   // こんにちは、山田 です
}

// ** Object literal **

namespace PropertySignature {
    let obj: {
        a: number;
        b: string;
        c?: boolean;
    }

    obj = {
        a: 999,
        b: 'hoge',
        c: false
    }

    obj = {
        a: 999,
        b: 'hoge'
    }
}

namespace MethodSignature {
    let obj: {
        hello(msg: string): string;
    }

    obj = {
        hello: (x: string) => {
            return 'hello' + x;
        }
    }

    alert(obj.hello('TypeScript')); // helloTypeScript
}

namespace CallSignature {
    let obj: {
        (x: string): string;
    }

    obj = function(x: string): string {
        return 'hello' + x;
    }

    alert(obj('TypeScript')); // helloTypeScript
}

namespace ConstructSignature {
    class Cls {
        constructor(private x: string) {
        }

        public hello(): string {
            return 'hello' + this.x;
        }
    }
    let obj: {
        new (x: string): Cls;
    }

    obj = Cls;

    let res = new obj('TypeScript');
    alert(res.hello()); // helloTypeScript
}

namespace IndexSignature {
    let obj: {
        [x: string]: number;
    }

    obj = {
        hoge: 777,
        fuga: 123
    };

    alert(obj['hoge']); // 777
}

namespace Generic {
    // generic class
    class Cls<T, U> {
        constructor(public x: T, private y: U) {
        }

        public resultX(): T {
            return this.x;
        }

        public resultY(): U {
            return this.y;
        }
    }

    let cls = new Cls<string, number>('TypeScript', 999);
    let x1:string = cls.resultX();   // TypeScript
    let y1:number = cls.resultY();   // 999

    // generic function
    function fnc<T>(x :T): T {
        return x;
    }

    let x2:string = fnc<string>('TypeScript');
    let y2:number = fnc<number>(999);
    let z:boolean = fnc<boolean>(true);

    interface Hoge {
        hoge(): string;
    }

    class HogeClass implements Hoge {
        public hoge(): string {
            return "hoge!";
        }
    }

    interface Fuga {
        fuga(): string;
    }

    class FugaClass implements Fuga {
        public fuga(): string {
            return "fuga";
        }
    }

    class Piyo<T extends Hoge> {
    }

    let piyo1 = new Piyo<HogeClass>();
    // let piyo2 = new Piyo<FugaClass>();  // error
}

namespace SetAndMap {
    // set
    let set = new Set<string>(['hoge', 'fuga']);

    set.add('piyo');
    set.add('hoge');

    let values:string = '';
    set.forEach(value => values += value);
    alert(values);  // hogefugapiyo

    // map
    let map = new Map<string, string>();

    map.set("key1", "value1");
    map.set("key2", "value2");
    map.set("key3", "value3");

    values = "";
    map.forEach(
        (value: string, key: string) => values += (key + '=' + value + ',')
    );
    alert(values); // key1=value1,key2=value2,key3=value3,
}

namespace IteratorGenerator {
    // generator
    function* getYieldValues() {
        for (let v of ['hoge', 'fuga', 'piyo']) {
            yield v;
        }
    }

    let it = getYieldValues();
    let values:string = '';

    // iterator
    for (let v = it.next(); v.done == false; v = it.next()) {
        values += v.value;
    }

    alert(values);  // hogefugapiyo
}
