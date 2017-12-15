const Film = require('../models/Film');

module.exports = {
	index: (req, res) => {
        Film.find().then(films => {
            res.render('film/index', {'films': films});
        });
	},

	createGet: (req, res) => {
        res.render('film/create')
	},

	createPost: (req, res) => {
        let filmArgs = req.body;

        let yearCheck = parseInt(filmArgs.year);

        if (!filmArgs.name || !filmArgs.genre
			|| !filmArgs.director || !filmArgs.year || isNaN(yearCheck)) {
            res.render('film/create');
            return;
        }

        Film.create(filmArgs)
            .then(res.redirect('/'));
	},

	editGet: (req, res) => {
        let id = req.params.id;

        Film.findById(id).then(film => {
            if (!film) {
                res.redirect('/');
                return;
            }

            res.render('film/edit', film)
        });
	},

	editPost: (req, res) => {
        let id = req.params.id;
        let filmArgs = req.body;

        let yearCheck = parseInt(filmArgs.year);

        if (!filmArgs.name || !filmArgs.genre
            || !filmArgs.director || !filmArgs.year || isNaN(yearCheck)) {
            res.redirect(`/`);
            return;
        }

        Film.update({_id: id}, {$set: {
                name: filmArgs.name,
                genre: filmArgs.genre,
                director: filmArgs.director,
                year: filmArgs.year,}})
            .then(res.redirect(`/`));
	},

	deleteGet: (req, res) => {
        let id = req.params.id;

        Film.findById(id).then(film => {
            if (!film) {
                res.redirect('/');
                return;
            }

            res.render('film/delete', film)
        });
	},

	deletePost: (req, res) => {
        let id = req.params.id;

        Film.findByIdAndRemove(id)
            .then(res.redirect('/'));
	}
};