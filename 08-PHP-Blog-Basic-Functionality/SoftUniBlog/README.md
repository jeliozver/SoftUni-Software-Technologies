Blog Basic Functionality - Symfony Web App
========================

Features
------------

* CRUD support for Articles;
* Index page displays maximum of 6 articles, ordered by date;
* Basic Roles system (Admin & User) in order to authenticate and authorize operations;
	* Only Admin and the author can edit/delete given article;
* Basic profile view for every user;
	* Displays username, email and the count of articles posted;
	* Dropdown button which lists the titles of all articles, posted by the current user, each entry has a link, leading to selected article details page;

Requirements
------------

  * PHP 5.5.9 or higher;
  * PDO-SQLite PHP extension enabled;
  * and the [usual Symfony application requirements](http://symfony.com/doc/current/reference/requirements.html).

If unsure about meeting these requirements, download the demo application and
browse the `http://localhost:8000/config.php` script to get more detailed
information.

Installation
------------

[![Deploy](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)

First, install the [Symfony Installer](https://github.com/symfony/symfony-installer)
if you haven't already. Then, install the Symfony Demo Application executing
this command anywhere in your system:

```bash
$ symfony demo

# if you're using Windows:
$ php symfony demo
```

If the `demo` command is not available, update your Symfony Installer to the
most recent version executing the `symfony self-update` command.

> **NOTE**
>
> If you can't use the Symfony Installer, download and install the demo
> application using Git and Composer:
>
>     $ git clone https://github.com/symfony/symfony-demo
>     $ cd symfony-demo/
>     $ composer install --no-interaction

Usage
-----

There is no need to configure a virtual host in your web server to access the application.
Just use the built-in web server:

```bash
$ cd symfony-demo/
$ php bin/console server:run
```

This command will start a web server for the Symfony application. Now you can
access the application in your browser at <http://localhost:8000>. You can
stop the built-in web server by pressing `Ctrl + C` while you're in the
terminal.

> **NOTE**
>
> If you want to use a fully-featured web server (like Nginx or Apache) to run
> Symfony Demo application, configure it to point at the `web/` directory of the project.
> For more details, see:
> http://symfony.com/doc/current/cookbook/configuration/web_server_configuration.html

Troubleshooting
---------------

The current Symfony Demo application uses Symfony 3.x version. If you want to
use the legacy Symfony 2.8 version, clone the Git repository and checkout the
`v0.8.4` tag, which is the last one compatible with Symfony 2.8:

```bash
$ git clone https://github.com/symfony/symfony-demo
$ cd symfony-demo/
$ git checkout tags/v0.8.4 -b v0.8.4
$ composer install
```
