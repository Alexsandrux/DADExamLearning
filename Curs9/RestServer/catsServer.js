var express = require('express')
var app = express()

app.use(express.json())


app.post("/getOldestCat", (req, res) => {
    var cats = req.body

    console.log(cats)


    var age = 0;
    var post_cat;
    cats.forEach(cat => {
        if (age < cat.age) {
            post_cat = cat
            age = cat.age
        }
    });

    console.log(post_cat)




    res.status(200).send(post_cat)
})


app.listen(8081, () => {
    console.log("Server listening on port 8081\n")
})