const Article = require('mongoose').model('Article');

module.exports = {
    createGet: (req, res) => {
        res.render('article/create');
    },

    createPost: (req, res) => {
        let articleArgs = req.body;

        articleArgs.author = req.user.id;

        Article.create(articleArgs).then(article => {
            req.user.articles.push(article.id);
            req.user.save(err => {
                if (err) {
                    res.redirect('/', {error: err.message});
                } else {
                    res.redirect('/');
                }
            });
        })
    },

    detailsGet: (req, res) => {
        let id = req.params.id;

        Article.findById(id).populate('author').then(article => {
            res.render('article/details', article)
        });
    },

    editGet: (req, res) => {
        let id = req.params.id;

        if (!req.isAuthenticated()) {
            let returnUrl = `/article/edit/${id}`;
            req.session.returnUrl = returnUrl;

            res.redirect('/user/login');
            return;
        }

        Article.findById(id).then(article => {
            req.user.isInRole('Admin').then(isAdmin => {
               if (!isAdmin && !req.user.isAuthor(article)) {
                   res.redirect('/');
                   return;
               }

                res.render('article/edit', article)
            });
        });
    },

    editPost: (req, res) => {
        let id = req.params.id;
        let articleArgs = req.body;

        Article.update({_id: id}, {$set: {
            title: articleArgs.title,
            content: articleArgs.content}})
            .then(res.redirect(`/article/details/${id}`));

    },

    deleteGet: (req, res) => {
        let id = req.params.id;

        if (!req.isAuthenticated()) {
            let returnUrl = `/article/delete/${id}`;
            req.session.returnUrl = returnUrl;

            res.redirect('/user/login');
            return;
        }

        Article.findById(id).then(article => {
            req.user.isInRole('Admin').then(isAdmin => {
               if (!isAdmin && !req.user.isAuthor(article)) {
                    res.redirect('/');
                    return;
                }

               res.render('article/delete', article)
            });
        });
    },

    deletePost: (req, res) => {
        let id = req.params.id;

        Article.findOneAndRemove({_id: id}).populate('author').then(article => {
            let author = article.author;
            let index = author.articles.indexOf(article.id);

            if (index < 0) {
                let errorMsg = 'Article was not found for that author!';
                res.render('article/delete', {error: errorMsg})
            } else {
                author.articles.splice(index, 1);
                author.save().then(res.redirect('/'));
            }
        });
    }
};