const Anime = require('../models/Anime');

module.exports = {
	index: (req, res) => {
        Anime.find().sort([['rating', 1]]).then(animes => {
           res.render('anime/index', {'animes': animes});
        });
	},

	createGet: (req, res) => {
        res.render('anime/create');
	},

	createPost: (req, res) => {
        let animeArgs = req.body;

        let ratingCheck = parseInt(animeArgs.rating);

        if (!animeArgs.name
            || !animeArgs.watched
            || !animeArgs.description
            || ratingCheck <= 0
            || isNaN(ratingCheck)) {
                res.render('anime/create');
            return;
        }

        Anime.create(animeArgs)
            .then(res.redirect('/'));
	},

    editGet: (req, res) => {
        let id = req.params.id;

        Anime.findById(id).then(anime => {
            if (!anime) {
                res.redirect('/');
                return;
            }

            res.render('anime/edit', anime);
        });
    },

    editPost: (req, res) => {
        let id = req.params.id;
        let animeArgs = req.body;

        let ratingCheck = parseInt(animeArgs.rating);

        if (!animeArgs.name
            || !animeArgs.description
            || !animeArgs.watched
            || isNaN(ratingCheck) )
        {
            res.redirect('/');
            return;
        }

        Anime.update({_id: id}, {$set: {
                name: animeArgs.name,
                description: animeArgs.description,
                watched: animeArgs.watched,
                rating: animeArgs.rating,}})
            .then(res.redirect(`/`));

    },

	deleteGet: (req, res) => {
        let id = req.params.id;

        Anime.findById(id).then(anime => {
           if (!anime) {
               res.redirect('/');
               return;
           }

           res.render('anime/delete', anime);
        });
	},

    deletePost: (req, res) => {
        let id = req.params.id;

        Anime.findByIdAndRemove(id)
            .then(res.redirect('/'));
    }
};