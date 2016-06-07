INSERT INTO User(Id, Email, Password, FirstName, LastName) VALUES
  (1, 'admin@entelect.co.za', 'test213', 'Ser', 'Admin'),
  (2, 'trainer@entelect.co.za', 'test123', 'Madam', 'Trainer'),
  (3, 'trainee@entelect.co.za', 'test123', 'Ser', 'Trainee');

INSERT INTO Course(Id, Name, Start, End) VALUES
  (1, 'SQL Optimization', '2016-07-01', '2016-07-02');

INSERT INTO CourseAttendee(Course, User) VALUES
  (1, 3);

INSERT INTO Session(Id, Course, Name, Date, Start, End) VALUES
  (1, 1, 'Query Performance Analysis', '2016-07-01', '08:00:00', '12:00:00'),
  (2, 1, 'Query Performance Tuning', '2016-07-01', '13:00:00', '17:00:00');

INSERT INTO SessionPresenters(Session, User) VALUES
  (1, 2),
  (2, 2);

INSERT INTO SessionAttendee(Id, Session, Trainee, Attended, Stars, Feedback) VALUES
  (1, 1, 3, false, null, null),
  (2, 2, 3, false, null, null);

