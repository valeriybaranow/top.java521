let num = 123.39999;

console.log(num.toFixed(2))

console.log(Math.round(num))
console.log(Math.floor(num))
console.log(Math.ceil(num))


console.log(Math.random())

function random(min, max) {
    return Math.floor(Math.random() * (max - min + 1) + min)
}

console.log(random(10, 20))

console.log(0.40173177132999494 * (10 - 5 + 1) + 5);
console.log(0.40173177132999494 * (10 - 5 + 1) + 5);