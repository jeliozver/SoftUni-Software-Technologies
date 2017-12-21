const Product = require('../models/Product');

module.exports = {
	index: (req, res) => {
        Product.find().sort([['priority', 1]]).then(products => {
            res.render('product/index', {'products': products});
        });
	},

	createGet: (req, res) => {
        res.render('product/create')
	},

	createPost: (req, res) => {
        let productArgs = req.body;

        let priorityCheck = parseInt(productArgs.priority);
        let quantityCheck = parseInt(productArgs.quantity);

        if (!productArgs.name || !productArgs.status
            || isNaN(quantityCheck) || isNaN(priorityCheck)) {
            res.render('product/create');
            return;
        }

        Product.create(productArgs)
            .then(res.redirect('/'));
	},

	editGet: (req, res) => {
        let id = req.params.id;

        Product.findById(id).then(product => {
            if (!product) {
                res.redirect('/');
                return;
            }

            res.render('product/edit', product)
        });
	},

	editPost: (req, res) => {
        let id = req.params.id;
        let productArgs = req.body;

        let priorityCheck = parseInt(productArgs.priority);
        let quantityCheck = parseInt(productArgs.quantity);

        if (!productArgs.name || !productArgs.status
            || isNaN(quantityCheck) || isNaN(priorityCheck)) {
            res.render('product/create');
            return;
        }

        Product.update({_id: id}, {$set: {
                priority: productArgs.priority,
                name: productArgs.name,
                quantity: productArgs.quantity,
                status: productArgs.status,
            }}).then(res.redirect(`/`));
	},

    deleteGet: (req, res) => {
	    let id = req.params.id;

        Product.findById(id).then(product => {
            if (!product) {
                res.redirect('/');
                return;
            }

            res.render('product/delete', product)
        });
    },

    deletePost: (req, res) => {
        let id = req.params.id;

        Product.findById(id).then(product => {
            if (!product) {
                res.redirect('/');
                return;
            }

            Product.findByIdAndRemove(id)
                .then(res.redirect('/'));
        });
    }
};