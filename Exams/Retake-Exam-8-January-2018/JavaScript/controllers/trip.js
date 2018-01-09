const Trip = require('../models/Trip');

module.exports = {
    index: (req, res) => {
        Trip.find().then(trips => {
            res.render('trip/index', {'trips': trips});
        });
    },

    createGet: (req, res) => {
        res.render('trip/create')
    },

    createPost: (req, res) => {
        let tripArgs = req.body;

        let businessCheck = parseInt(tripArgs.business);
        let economyCheck = parseInt(tripArgs.economy);

        if (!tripArgs.origin || !tripArgs.destination
            || isNaN(economyCheck) || isNaN(businessCheck)) {
            res.render('trip/create');
            return;
        }

        Trip.create(tripArgs)
            .then(res.redirect('/'));
    },

    editGet: (req, res) => {
        let id = req.params.id;

        Trip.findById(id).then(trip => {
            if (!trip) {
                res.redirect('/');
                return;
            }

            res.render('trip/edit', trip)
        });
    },

    editPost: (req, res) => {
        let id = req.params.id;
        let tripArgs = req.body;

        let businessCheck = parseInt(tripArgs.business);
        let economyCheck = parseInt(tripArgs.economy);

        if (!tripArgs.origin || !tripArgs.destination
            || isNaN(economyCheck) || isNaN(businessCheck)) {
            res.render('trip/create');
            return;
        }

        Trip.update({_id: id}, {$set: {
                origin: tripArgs.origin,
                destination: tripArgs.destination,
                business: tripArgs.business,
                economy: tripArgs.economy,
            }}).then(res.redirect(`/`));
    },

    deleteGet: (req, res) => {
        let id = req.params.id;

        Trip.findById(id).then(trip => {
            if (!trip) {
                res.redirect('/');
                return;
            }

            res.render('trip/delete', trip)
        });
    },

    deletePost: (req, res) => {
        let id = req.params.id;

        Trip.findById(id).then(trip => {
            if (!trip) {
                res.redirect('/');
                return;
            }

            Trip.findByIdAndRemove(id)
                .then(res.redirect('/'));
        });
    }
};