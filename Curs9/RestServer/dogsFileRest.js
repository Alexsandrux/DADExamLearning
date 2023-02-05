const { response } = require('express')
var express = require('express')
var fs = require('fs')

var app = express()

app.use(express.json())


app.get("/oldestDog", (req, res) => {
    fs.readFile(__dirname + "/" + "dogs.json", "utf8", (err, data) => {

        var dogs = JSON.parse(data)

        console.log(dogs)

        var age = 0
        var get_dog
        dogs.forEach(element => {
            if (age < element.age) {
                age = element.age
                get_dog = element
            }
        });


        console.log(get_dog)

        res.status(200).send("Succes!!" + JSON.stringify(get_dog))
    })


})





app.listen(8081, () => {
    console.log("Server listening on port 8081")
})
