const Task = require('../models/Task');

module.exports = {
	index: (req, res) => {
	    Task.find().then(tasks => {
	        res.render('task/index', {
	            'openTasks': tasks.filter(s => s.status === 'Open'),
                'inProgressTasks': tasks.filter(s => s.status === 'In Progress'),
                'finishedTasks': tasks.filter(s => s.status === 'Finished'),
            });
        });
	},

	createGet: (req, res) => {
        res.render('task/create');
	},

	createPost: (req, res) => {
        let taskArgs = req.body;

        if (!taskArgs.title || !taskArgs.status) {
            res.render('task/create');
            return;
        }

        Task.create(taskArgs).then(res.redirect('/'));
	},

	editGet: (req, res) => {
        let id = req.params.id;

        Task.findById(id).then(task => {
            if (!task) {
                res.redirect('/');
                return;
            }

            res.render('task/edit', task)
        });
	},

	editPost: (req, res) => {
        let id = req.params.id;
        let taskArgs = req.body;

        if (!taskArgs.title || !taskArgs.status) {
            res.redirect(`/`);
            return;
        }

        Task.update({_id: id}, {$set: {
                title: taskArgs.title,
                status: taskArgs.status,
            }})
            .then(res.redirect(`/`));
	}
};