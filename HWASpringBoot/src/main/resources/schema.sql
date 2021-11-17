DROP TABLE IF EXISTS boat_clubs;
DROP TABLE IF EXISTS boats;

CREATE TABLE boat_clubs (
	boat_club_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	boat_club_name VARCHAR(255) NOT NULL,
	address VARCHAR(255) NOT NULL,
	boat_club_code CHAR(3) NOT NULL,
	head_coach_first_name VARCHAR(255) NOT NULL,
	head_coach_surname VARCHAR(255) NOT NULL
);

CREATE TABLE boats (
	boat_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	boat_type VARCHAR(3) NOT NULL,
	boat_company VARCHAR(255) NOT NULL,
	avg_crew_weight INT NOT NULL,
	rigger_material VARCHAR(255) NOT NULL,
	is_wing_rigger CHAR(1) NOT NULL,
	boat_club_id INT NOT NULL,
	FOREIGN KEY (boat_club_id) REFERENCES boat_clubs (boat_club_id),
	ON DELETE CASCADE
);