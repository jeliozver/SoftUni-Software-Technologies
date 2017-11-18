const mongoose = require('mongoose');
const Article = mongoose.model('Article');

module.exports = {
  index: (req, res) => {

      Article.find().sort({"date": -1}).limit(6).populate('author').then(articles => {
          res.render('home/index', {articles: articles});
      })
  }
};