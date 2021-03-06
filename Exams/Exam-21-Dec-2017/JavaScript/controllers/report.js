const Report = require('../models/Report');

module.exports = {
    index: (req, res) => {
        Report.find().then(reports => {
            res.render('report/index', {'reports': reports});
        });
    },

    createGet: (req, res) => {
        res.render('report/create')
    },

    createPost: (req, res) => {
        let reportArgs = req.body;

        if (!reportArgs.status || !reportArgs.message
            || !reportArgs.origin) {
            res.render('report/create');
            return;
        }

        Report.create(reportArgs)
            .then(res.redirect('/'));
    },

    detailsGet: (req, res) => {
        let id = req.params.id;

        Report.findById(id).then(report => {
            if (!report) {
                res.redirect('/');
                return;
            }

            res.render('report/details', report)
        });
    },

    editGet: (req, res) => {
        let id = req.params.id;

        Report.findById(id).then(report => {
            if (!report) {
                res.redirect('/');
                return;
            }

            res.render('report/edit', report)
        });
    },

    editPost: (req, res) => {
        let id = req.params.id;
        let reportArgs = req.body;

        if (!reportArgs.status || !reportArgs.message
            || !reportArgs.origin) {
            res.redirect('/');
            return;
        }

        Report.update({_id: id}, {$set: {
                status: reportArgs.status,
                message: reportArgs.message,
                origin: reportArgs.origin,
            }}).then(res.redirect(`/`));
    },

    deleteGet: (req, res) => {
        let id = req.params.id;

        Report.findById(id).then(report => {
            if (!report) {
                res.redirect('/');
                return;
            }

            res.render('report/delete', report)
        });
    },

    deletePost: (req, res) => {
        let id = req.params.id;

        Report.findById(id).then(report => {
            if (!report) {
                res.redirect('/');
                return;
            }

            Report.findByIdAndRemove(id)
                .then(res.redirect('/'));
        });
    }
};