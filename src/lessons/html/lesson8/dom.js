// console.log(document.children[0].children[1].children[0].innerHTML = 'test')

// document.getElementById()
// document.getElementsByTagName()
// document.getElementsByClassName()
// document.getElementsByName()
// document.querySelector()
// document.querySelectorAll()


// document.getElementsByTagName('h1')[0].innerText = 'Test'

// let h1s = document.getElementsByTagName('h1')

// for (const h1 of h1s) {
//     h1.innerHTML = 'test1'
// }

// let tests = document.getElementsByClassName('test')

// for (const test of tests) {
//     test.innerHTML = 'test10'
// }

// let id = document.getElementById('test')

// id.innerHTML = 'farid'


// let h1 = document.querySelector('h1')

// h1.innerText = 'h1'


let temps = document.querySelectorAll('h1')

let i = 1;
for (const temp of temps) {
    test.innerHTML = 'test10' + i++;
}

let element = document.querySelector('h1')

// element.style = 'color:red'
// element.style = 'margin:100px'

element.style.color = 'red'
element.style.fontSize = '10px'
element.style.margin = '10px'
element.style.setProperty('color', 'green')


let box = {
    element: document.querySelector('.box'),
    x: 0,
    y: 0,
    num: 1,
    setPosition: function () {
        this.element.style.top = this.y + 'px'
        this.element.style.left = this.x + 'px'
    },
    height: element.style.height
}

const wh = window.innerHeight
const ww = window.innerWidth
setInterval(() => {
        if (box.left > wh - box.height) {
            box.y -= 100
        } else if (box.y < wh - 200) {
            box.y += 100
        } else if (box.x < wh - 200) {
            box.x += 100
        }


        box.setPosition()

    }, 100
)