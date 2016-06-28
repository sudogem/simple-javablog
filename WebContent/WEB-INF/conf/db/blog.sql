-- MySQL dump 10.11
--
-- Host: localhost    Database: blog
-- ------------------------------------------------------
-- Server version	5.0.67

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `blogs`
--

DROP TABLE IF EXISTS `blogs`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `blogs` (
  `id` int(11) NOT NULL auto_increment,
  `author_id` int(3) NOT NULL,
  `title` varchar(255) NOT NULL,
  `blog` text NOT NULL,
  `date_created` datetime default NULL,
  `date_last_updated` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `blogs`
--

LOCK TABLES `blogs` WRITE;
/*!40000 ALTER TABLE `blogs` DISABLE KEYS */;
INSERT INTO `blogs` (`id`, `author_id`, `title`, `blog`, `date_created`, `date_last_updated`) VALUES (1,1,'blog01','Sed eu tempor libero. Vivamus egestas lorem at tellus hendrerit posuere eget ac dolor. In lectus magna, tincidunt ac tincidunt ac, tincidunt non urna. Mauris et libero felis. Donec in gravida nisi. Duis posuere blandit diam, eget semper elit luctus et. In hac habitasse platea dictumst. Morbi condimentum tristique ipsum, non placerat purus lobortis at! Aliquam justo orci, cursus eu interdum a, ultrices sed velit. Aliquam quam nibh; dictum vel vehicula sed, commodo eu augue. Fusce viverra, ante sed egestas interdum, diam felis semper elit; ac fermentum urna turpis et dui.\r\n\r\nIn non augue id neque semper euismod. Donec ullamcorper commodo eros a malesuada? Suspendisse vel tellus sem. Duis vel arcu lacus. Nunc molestie mi nec elit pharetra porttitor faucibus orci malesuada? Pellentesque elit lacus, dignissim eget convallis et, dapibus at nulla. Nulla vel felis sapien, vitae lobortis quam? Aliquam quis sem orci, et venenatis orci? Nullam sapien elit, adipiscing eget bibendum eu, dapibus et purus. Cras pretium, nulla et faucibus consectetur, eros lectus dictum libero, sed mattis erat leo eu turpis. Etiam leo sapien, elementum ac varius in, viverra porta arcu. Fusce cursus viverra lacus, tincidunt accumsan dui rutrum vitae. Quisque quis metus vitae purus sollicitudin blandit.\r\n\r\nDonec at eros purus, ut eleifend dui. Sed consectetur auctor nisl et eleifend. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nulla quis risus lectus? Praesent urna lacus, euismod a rutrum vitae, gravida et enim. Maecenas viverra adipiscing elit et molestie. Donec molestie blandit commodo? Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Etiam lobortis, sem sit amet molestie vulputate, augue felis adipiscing magna, vel porta purus risus et eros. Integer gravida metus ac dolor ultrices id tristique urna facilisis. Nullam mattis; est et sollicitudin iaculis, tellus urna molestie erat, nec condimentum lacus augue eu purus? Sed elit libero, commodo a dictum eget; ullamcorper ac lorem. Integer est mauris, commodo commodo pretium non; semper non odio.\r\n','2010-06-24 18:34:22',NULL),(2,1,'blog02','Nullam aliquam sem ut libero pretium auctor. Proin mattis vulputate massa, quis sagittis dolor tincidunt at. Nam aliquet, nisi sit amet ultrices luctus, nisl libero vulputate nisl, vitae cursus est orci ut nibh. Vestibulum quis augue ac turpis lobortis fermentum quis id leo. Ut viverra feugiat eros, ac auctor tellus semper et. Duis lobortis; mi sed pretium venenatis, quam purus mattis est, sed gravida urna elit et erat. Aenean nec massa consectetur massa dignissim iaculis vel in turpis. Vestibulum ac feugiat mi. Nam sagittis metus et quam ornare euismod posuere eget purus. Quisque eros purus, porta non sollicitudin a; sollicitudin lobortis dui. Cras adipiscing luctus risus vel venenatis. Proin pharetra tellus ac leo tincidunt rutrum! Ut varius, lorem sagittis suscipit dapibus, turpis odio sagittis lorem, id tristique lectus magna id enim. Etiam magna augue; tempor at commodo euismod, consequat vitae velit? Aenean leo lectus, elementum eget pretium sit amet, mollis non purus. Aliquam et dignissim nunc! Phasellus a enim velit, vitae aliquam turpis. Phasellus id nulla massa, nec interdum nulla.\r\n\r\nPraesent lobortis, enim et cursus viverra, lectus augue auctor urna, at ullamcorper erat arcu non urna. Maecenas placerat, leo quis egestas ultrices, augue lacus pellentesque dui, vitae congue neque nulla vitae risus. Maecenas rutrum pellentesque purus in ornare. Fusce porta massa non mauris accumsan tempor. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Praesent est quam, bibendum a rhoncus non, facilisis vel lorem. Nulla non justo arcu, sed porttitor massa. Vivamus in neque eget lorem scelerisque pharetra. Aliquam pharetra auctor tincidunt. Ut cursus lorem ac dui laoreet rutrum? Duis vitae rhoncus nisl. Maecenas porttitor dapibus vestibulum. Sed bibendum facilisis est, eu egestas tellus commodo at. In ut odio vitae nisi sodales malesuada. Sed porta neque at dui facilisis non malesuada augue sollicitudin. Duis blandit nibh eget quam sodales ornare? Suspendisse potenti. Donec luctus, lacus quis bibendum ullamcorper, dolor ipsum pulvinar nulla, rutrum suscipit purus nulla at nisl.\r\n\r\nAliquam eget nisl orci; id faucibus erat. Nunc fringilla justo et enim egestas non porttitor sem tempor! Suspendisse molestie tempus nulla, eu luctus erat fermentum sit amet. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam vehicula suscipit lectus non blandit. Nulla quis massa sapien, posuere egestas ligula. Donec eget ligula felis. Donec et vulputate diam. Phasellus ultricies sollicitudin mollis. Nunc id justo est. Aenean odio magna, laoreet lacinia venenatis vitae, pellentesque in turpis. Sed vitae nisi vehicula ante pretium fringilla. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vivamus non ligula lacus, sed rhoncus odio. Pellentesque ut augue nisi.\r\n\r\nNullam quis est sem. Quisque vel sapien et enim sagittis ultricies et in neque. Aenean dui mi, dictum non ultricies at, mattis vel magna. Ut malesuada laoreet egestas. Cras ipsum nulla, tristique sit amet vestibulum nec, aliquet eu mauris! Quisque nec dui magna. Proin cursus libero eget odio pellentesque condimentum. Vestibulum sagittis pulvinar semper. Vestibulum vitae massa tempus orci tincidunt consequat eget in ipsum. Praesent ornare gravida sem, vitae mattis lorem hendrerit ut! Sed eget urna metus; sed ultricies quam. Fusce nec est non libero iaculis sollicitudin.\r\n\r\nMaecenas rhoncus sodales nisl non volutpat. Proin dapibus ullamcorper feugiat! Suspendisse scelerisque sagittis massa, eu vehicula nunc venenatis a. Praesent aliquam, risus id eleifend eleifend, leo odio ultricies lacus, in placerat justo tortor quis libero. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus scelerisque vehicula scelerisque. Maecenas vel mauris lectus. In non luctus arcu. Duis varius dignissim eros, faucibus tempus ligula pretium ultrices? Nullam venenatis adipiscing augue; et auctor augue sollicitudin id. Praesent vel turpis eu leo venenatis suscipit\r\n','2010-06-24 18:36:13',NULL);
/*!40000 ALTER TABLE `blogs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `users` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(10) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) default NULL,
  `date_registered` datetime NOT NULL,
  `is_admin` tinyint(1) default '0',
  `is_active` tinyint(1) default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `username`, `password`, `email`, `date_registered`, `is_admin`, `is_active`) VALUES (1,'user01','user01','user01@user01.com','2010-06-24 16:29:48',0,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2010-06-24 22:40:41
