const mongoose = require('mongoose');
require('mongoose-long')(mongoose);

let projectSchema = mongoose.Schema({
    title: {type: 'String', required: 'true'},
    description: {type: 'String', required: 'true'},
    budget: {type: mongoose.Types.Long, required: 'true'},
});

let Project = mongoose.model('Project', projectSchema);

module.exports = Project;