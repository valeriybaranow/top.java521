console.log(11)


let person = {
    name: 'test',
}


let createPerson = (n, a, c) => {
    return {
        name: n,
        age: a,
        city: c,
        greet: function () {
            return `Privet< ${this.name}`
        }
    }
}

let people = [];
let names = ['Farid', 'David', 'Cavid']
let cities = ['Farid', 'David', 'Cavid']

for (let i = 0; i < 3; i++) {
    let person = createPerson(names[i], (i + 1), cities[i]);
}

class Person {
    constructor(n, a, c) {
        this.name = a
    }

    greet() {
        return this.name
    }
}

let createPerson1 = (n, a, c) => {
    this.name = n
    this.city = a
}