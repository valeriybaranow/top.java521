let interval

let box = {
    element: document.querySelector('.box'),
    gameField: document.querySelector('body'),
    btnStart: document.querySelector('.btn-start'),
    height: 100,
    width: 100,
    x: 0,
    y: 0,
    numCircles: 1,
    speed: 200,
    step: 100,
    maxX: window.innerWidth - 100,
    maxY: window.innerHeight - 100,
    minX: 0,
    minY: 0,
    direction: 'down',
    init: function () {
        this.btnStart.addEventListener('click', () => {
            this.startMoving()
        })
    },
    setPosition: function () {
        this.element.style.top = this.y + 'px'
        this.element.style.left = this.x + 'px'
    },
    setNumCircle: function () {
        if (this.x == 0 && this.y == 0) {
            this.element.innerHTML = this.numCircles++
        }
    },
    reset: function () {
        this.numCircles = 1
        this.x = 0
        this.y = 0
        this.setNumCircle()
        this.setPosition()
    },
    setDirection: function () {
        if (this.x == this.minX && this.y == this.minY) {
            this.direction = 'down'
        }
        if (this.x == this.minX && this.y == this.maxY) {
            this.direction = 'right'
        }
        if (this.x == this.maxX && this.y == this.maxY) {
            this.direction = 'top'
        }
        if (this.x == this.maxX && this.y == this.minY) {
            this.direction = 'left'
        }
    },
    startMoving: function () {
        this.gameField.classList.remove('game-over')
        this.gameField.classList.add('start')
        this.btnStart.classList.replace('visible', 'hidden')
        this.element.classList.replace('hidden', 'visible')
        const maxX = window.innerWidth - this.width
        const maxY = window.innerHeight - this.height
        const minX = 0
        const minY = 0

        this.reset()

        // const step = this.width
        interval = setInterval(() => {
            if (this.numCircles == 5) {
                this.finishMoving()
            } else {
                this.setDirection();
                if (this.direction == 'down') {
                    this.y = ((this.y + this.step) < maxY) ? this.y + this.step : maxY
                }
                if (this.direction == 'right') {
                    this.x = ((this.x + this.step) < maxX) ? this.x + this.step : maxX
                }
                if (this.direction == 'top') {
                    this.y = ((this.y - this.step) > minY) ? this.y - this.step : minY
                }
                if (this.direction == 'left') {
                    this.x = ((this.x - this.step) > minX) ? this.x - this.step : minX
                }
                this.setPosition()
                this.setNumCircle()
            }
        }, this.speed)
    },
    finishMoving: function () {
        document.querySelector('.btn-start').classList.replace('hidden', 'visible')
        document.querySelector('body').classList.remove('start')
        document.querySelector('body').classList.add('game-over')
        this.element.classList.replace('visible', 'hidden')
        clearInterval(interval)
    }
}

box.init()
