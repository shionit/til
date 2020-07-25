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

// Object literal


