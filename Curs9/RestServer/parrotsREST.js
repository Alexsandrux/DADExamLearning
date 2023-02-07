var express = require('express')

var app = express()

app.use(express.json())


app.get("/fatestParrot", (req, res) => {
    var parrots = req.body

    console.log(parrots)

    // var maxWeight = 0
    // var fatestParrot = null;
    // parrots.forEach(element => {
    //     if (maxWeight < element.weight) {
    //         maxWeight = element.weight
    //         fatestParrot = element
    //     }
    // });


    // fatestParrot = parrots.reduce((fatestParrot, parrot) => {
    //     console.log(fatestParrot)
    //     if (fatestParrot == null) {
    //         return parrot
    //     }
    //     if (fatestParrot.weight < parrot.weight) {
    //         return parrot
    //     }

    //     return fatestParrot;
    // }, null)

    fatestParrot = parrots.sort((elem1, elem2) => {
        if (elem1.weight == elem2.weight) {
            return 0
        }

        if (elem1.weight < elem2.weight) {
            return 1
        }

        return -1;
    }).slice(0, 1)


    res.status(200).send("Success!! " + JSON.stringify(fatestParrot))
})





app.listen(8081, () => {
    console.log("Server is listening...")
}) 