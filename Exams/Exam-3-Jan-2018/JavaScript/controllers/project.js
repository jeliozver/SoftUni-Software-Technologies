const Project = require('../models/Project');

module.exports = {
    index: (req, res) => {
        Project.find().then(projects => {
            res.render('project/index', {'projects': projects});
        });
    },

    createGet: (req, res) => {
        res.render('project/create')
    },

    createPost: (req, res) => {
        let projectArgs = req.body;

        let budgetCheck = parseInt(projectArgs.budget);

        if (!projectArgs.title || !projectArgs.description
            || isNaN(budgetCheck)) {
            res.render('project/create');
            return;
        }

        Project.create(projectArgs)
            .then(res.redirect('/'));
    },

    editGet: (req, res) => {
        let id = req.params.id;

        Project.findById(id).then(project => {
            if (!project) {
                res.redirect('/');
                return;
            }

            res.render('project/edit', project)
        });
    },

    editPost: (req, res) => {
        let id = req.params.id;
        let projectArgs = req.body;

        let budgetCheck = parseInt(projectArgs.budget);

        if (!projectArgs.title || !projectArgs.description
            || isNaN(budgetCheck)) {
            res.redirect('/');
            return;
        }

        Project.update({_id: id}, {$set: {
                title: projectArgs.title,
                description: projectArgs.description,
                budget: projectArgs.budget,
            }}).then(res.redirect(`/`));
    },

    deleteGet: (req, res) => {
        let id = req.params.id;

        Project.findById(id).then(project => {
            if (!project) {
                res.redirect('/');
                return;
            }

            res.render('project/delete', project)
        });
    },

    deletePost: (req, res) => {
        let id = req.params.id;

        Project.findById(id).then(project => {
            if (!project) {
                res.redirect('/');
                return;
            }

            Project.findByIdAndRemove(id)
                .then(res.redirect('/'));
        });
    }
};