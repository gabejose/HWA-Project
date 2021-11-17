DROP TABLE IF EXISTS boatclubs;
DROP TABLE IF EXISTS boats;

CREATE TABLE IF NOT EXISTS boat_clubs (
	boat_club_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	boat_club_name NOT NULL VARCHAR(255),
	address NOT NULL VARCHAR(255),
	boat_club_code NOT NULL CHAR(3),
	head_coach_first_name NOT NULL VARCHAR(255),
	head_coach_surname NOT NULL VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS boats (
	boat_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	boat_type NOT NULL VARCHAR(3),
	boat_company NOT NULL VARCHAR(255),
	avg_crew_weight NOT NULL INT,
	rigger_material NOT NULL VARCHAR(255),
	is_wing_rigger NOT NULL CHAR(1),
	boat_club_id INT NOT NULL
	FOREIGN KEY (boat_club_id) REFERENCES boat_clubs (boat_club_id)
	ON DELETE CASCADE
);