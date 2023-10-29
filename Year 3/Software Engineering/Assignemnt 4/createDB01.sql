

DROP TABLE IF EXISTS `artists`;
CREATE TABLE IF NOT EXISTS `artists` (
  `artistid` int(11) NOT NULL AUTO_INCREMENT,
  `surname` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `yob` smallint(6) NOT NULL,
  `nationality` varchar(255) NOT NULL,
  `biography` longtext NOT NULL,
  PRIMARY KEY (`artistid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `artists`
--

INSERT INTO `artists` (`artistid`, `surname`, `firstname`, `yob`, `nationality`, `biography`) VALUES
(1, 'Steinbeck', 'John', 1902, 'American', 'John Ernst Steinbeck was an American writer. He won the 1962 Nobel Prize in Literature \"for his realistic and imaginative writings, combining as they do sympathetic humor and keen social perception\". He has been called \"a giant of American letters.\" '),
(2, 'Linklater', 'Eric', 1899, 'British', 'Eric Robert Russell Linklater CBE was a Welsh-born Scottish poet, fiction writer, military historian, and travel writer. For The Wind on the Moon, a children\'s fantasy novel, he won the 1944 Carnegie Medal from the Library Association for the year\'s best children\'s art by a British subject.');

-- --------------------------------------------------------

--
-- Table structure for table `artworks`
--

DROP TABLE IF EXISTS `artworks`;
CREATE TABLE IF NOT EXISTS `artworks` (
  `artworkid` int(11) NOT NULL AUTO_INCREMENT,
  `year` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `imagename` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `medium` varchar(255) NOT NULL,
  `artistid` int(11) NOT NULL,
  PRIMARY KEY (`artworkid`),
  KEY `artistid` (`artistid`) USING BTREE,
  FOREIGN KEY (`artistid`) REFERENCES `artists`(`artistid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `artworks`
--

INSERT INTO `artworks` (`artworkid`, `year`, `title`, `imagename`, `description` ,`medium` , `artistid`) VALUES
(1, 1962, 'Travels with Charley: In Search of America', 'png1', 'some description', 'some medium', 1),
(2, 1961, 'The Winter of Our Discontent', 'png2', 'some description', 'some medium', 1),
(3, 1946, 'Private Angelo', 'png3', 'some description', 'some medium', 2),
(4, 1952, 'Ripeness is All', 'png4', 'some description', 'some medium', 2);
COMMIT;

