# SPMS

## Project Description

SPMS, or Story Pitch Management System, is a full-stack web application that allows authors to submit story pitches to a publishing company. 
The pitch can then be approved or rejected by editors at various levels and in various committees based on genre and story length before the 
author is able to submit a draft of the story. The authors are able to track the status of their pitches throughout the process.

## Technologies Used

* Java v1.8
* PostgreSQL v13
* DBeaver v7.3
* HTML/JavaScript

## Features

* Register/Login User
* View Status of Pitches
* Create & Submit New Pitches
* Submit/Edit Story Draft (pending pitch approval)
* As Employee, Accept/Reject Pitches
* As Employee, Request Info from Author
* As Employee, Vote to Approve Draft

## Getting Started
   
To clone: "git clone https://github.com/Eric-Ro/SPMS

## Usage

Once the project is cloned, a local PostgreSQL database will need to be installed on the machine running SPMS. 
Make sure the url, username, and password are correctly defined in the database.properties file under src/main/resources.
Use the following SQL to generate the proper ERD:
"-- spms.genres definition

-- Drop table

-- DROP TABLE spms.genres;

CREATE TABLE spms.genres (
	id serial NOT NULL,
	name varchar(30) NOT NULL,
	CONSTRAINT genres_name_key UNIQUE (name),
	CONSTRAINT genres_pkey PRIMARY KEY (id)
);


-- spms.jobs definition

-- Drop table

-- DROP TABLE spms.jobs;

CREATE TABLE spms.jobs (
	id serial NOT NULL,
	name varchar(30) NOT NULL,
	CONSTRAINT jobs_name_key UNIQUE (name),
	CONSTRAINT jobs_pkey PRIMARY KEY (id)
);


-- spms.status definition

-- Drop table

-- DROP TABLE spms.status;

CREATE TABLE spms.status (
	id serial NOT NULL,
	name varchar(30) NOT NULL,
	CONSTRAINT status_name_key UNIQUE (name),
	CONSTRAINT status_pkey PRIMARY KEY (id)
);


-- spms.storytypes definition

-- Drop table

-- DROP TABLE spms.storytypes;

CREATE TABLE spms.storytypes (
	id serial NOT NULL,
	name varchar(30) NOT NULL,
	weight int4 NULL,
	CONSTRAINT storytypes_name_key UNIQUE (name),
	CONSTRAINT storytypes_pkey PRIMARY KEY (id)
);


-- spms.persons definition

-- Drop table

-- DROP TABLE spms.persons;

CREATE TABLE spms.persons (
	id serial NOT NULL,
	username varchar(30) NOT NULL,
	passw varchar(30) NOT NULL,
	job int4 NOT NULL,
	CONSTRAINT persons_pkey PRIMARY KEY (id),
	CONSTRAINT persons_job_fkey FOREIGN KEY (job) REFERENCES spms.jobs(id)
);


-- spms.pitches definition

-- Drop table

-- DROP TABLE spms.pitches;

CREATE TABLE spms.pitches (
	author int4 NULL,
	authorname varchar(30) NOT NULL,
	genre int4 NULL,
	pitchtype int4 NULL,
	status int4 NULL,
	title varchar(100) NOT NULL,
	compldate int4 NOT NULL,
	tagline varchar(50) NOT NULL,
	description varchar(65535) NOT NULL,
	extrainfo varchar(65535) NULL,
	id serial NOT NULL,
	votes int4 NULL,
	priority varchar(30) NULL,
	CONSTRAINT pitches_pkey PRIMARY KEY (id),
	CONSTRAINT pitches_author_fkey FOREIGN KEY (author) REFERENCES spms.persons(id),
	CONSTRAINT pitches_genre_fkey FOREIGN KEY (genre) REFERENCES spms.genres(id),
	CONSTRAINT pitches_pitchtype_fkey FOREIGN KEY (pitchtype) REFERENCES spms.storytypes(id),
	CONSTRAINT pitches_status_fkey FOREIGN KEY (status) REFERENCES spms.status(id)
);


-- spms.committees definition

-- Drop table

-- DROP TABLE spms.committees;

CREATE TABLE spms.committees (
	employee int4 NULL,
	team int4 NULL,
	CONSTRAINT committees_employee_fkey FOREIGN KEY (employee) REFERENCES spms.persons(id),
	CONSTRAINT committees_team_fkey FOREIGN KEY (team) REFERENCES spms.genres(id)
);"

Once tables have been generated, they must be populated with appropriate values. 
Next, to start the program, run the JavalinApp.java file from an appropriate IDE such as Eclipse or IntelliJ. This will start the Javalin instance on port 8080.
To open the webpage, make sure Javalin has finished initializing, then open any web browser and navigate to url "localhost:8080".
