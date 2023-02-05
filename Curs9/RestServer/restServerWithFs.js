var express = require('express')
var app = express()
var fs = require('fs')

app.use(express.json())

app.get('/dogs', function (req, res) {
    fs.readFile(__dirname + "/" + "dogs.json", 'utf-8', function (err, data) {
        console.log(data)
        res.end(data);
    })
})

app.post('/add-dog', function (req, res) {
    fs.readFile(__dirname + "/" + "dogs.json", "utf-8", function (err, data) {
        data = JSON.parse(data);


        var dog = { "name": req.body.name, "age": req.body.age };
        data.push(dog);
        console.log(data);

        fs.writeFileSync(__dirname + "/" + "dogs.json", JSON.stringify(data));

        res.end(JSON.stringify(data));

    })

})

var server = app.listen(8081, function () {

    var host = server.address().address
    var port = server.address().port

    console.log("Example app listening at http://%s:%s", host, port)

})