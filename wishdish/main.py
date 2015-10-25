import sqlite3
from flask import Flask, request, session, g, redirect, url_for, abort, render_template, flash
from jinja2 import Environment, PackageLoader
from contextlib import closing

# configuration
DATABASE = '/tmp/flaskr.db'
DEBUG = True
SECRET_KEY = 'development key'
USERNAME = 'admin'
PASSWORD = 'default'

#env = Environment(loader=PackageLoader('wishdish', 'templates'))
app = Flask(__name__)
app.config.from_object(__name__)

@app.route('/')
def index():
	return render_template('index.html', items =  [
		{'name': 'Shawarma', 'description': 'A delicious chicken delicacy', 'price':4.59, 'restriction':'Halal', 'preptime':5,'isinstock':1}, 
		{'name': 'Spring Rolls', 'description': 'Not Summer. Not Winter. Not Fall.', 'price':3.59, 'restriction':'Kosher', 'preptime':3,'isinstock':1}, 
		{'name': 'Buffalo Sweet Chicken Sushi w/ Whipped Cream', 'description': 'Something that should not exist', 'price':4.99, 'restriction':'None', 'preptime':15,'isinstock':1}
	]);

def connect_db():
	return sqlite3.connect(app.config['DATABASE'])

def init_db():
    with closing(connect_db()) as db:
        with app.open_resource('schema.sql', mode='r') as f:
            db.cursor().executescript(f.read())
        db.commit()

if __name__ == '__main__':
	app.debug = True;
	app.run()