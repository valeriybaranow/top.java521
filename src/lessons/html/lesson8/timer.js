function test() {
    console.log('Farid')
}

// test()

// setTimeout(test, 1 * 1000)

// setTimeout(() => {
//     console.log("Farid")
// }, 5 * 1000)

let count = 1

// setInterval(test, 1 * 1000)

let id = setInterval(() => {
        if (count == 10) {
            clearInterval(id)
        }
        console.log(count++)
    }
    , 1 * 500
)

