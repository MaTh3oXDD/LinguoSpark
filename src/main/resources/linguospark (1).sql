-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 29 Lip 2024, 23:40
-- Wersja serwera: 10.4.27-MariaDB
-- Wersja PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `linguospark`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name_category` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Zrzut danych tabeli `category`
--

INSERT INTO `category` (`id`, `name_category`) VALUES
(1, 'Food'),
(2, 'Sport'),
(3, 'Body parts'),
(4, 'Jobs');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Zrzut danych tabeli `client`
--

INSERT INTO `client` (`id`, `username`, `password`, `email`) VALUES
(1, 'xdd', 'xdd', 'xdd'),
(5, 'Login', 'Password', 'email@example.com'),
(7, 'MaTh3o', '1234', 'sadsa@gmail.com'),
(8, 'Username', 'Password', 'Email'),
(9, 'johndoe', 'securePass1', 'johndoe@example.com'),
(10, 'janedoe', 'securePass2', 'janedoe@example.com'),
(11, 'alice', 'securePass3', 'alice@example.com'),
(12, 'bob', 'securePass4', 'bob@example.com'),
(13, 'charlie', 'securePass5', 'charlie@example.com'),
(14, 'david', 'securePass6', 'david@example.com'),
(15, 'eve', 'securePass7', 'eve@example.com'),
(16, 'frank', 'securePass8', 'frank@example.com'),
(17, 'grace', 'securePass9', 'grace@example.com'),
(18, 'heidi', 'securePass10', 'heidi@example.com');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `errors`
--

CREATE TABLE `errors` (
  `id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `word_id` int(11) NOT NULL,
  `error_count` int(11) NOT NULL DEFAULT 0,
  `attempt_count` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Zrzut danych tabeli `errors`
--

INSERT INTO `errors` (`id`, `client_id`, `word_id`, `error_count`, `attempt_count`) VALUES
(208, 1, 1, 2, 3),
(209, 1, 2, 1, 2),
(210, 5, 9, 2, 3),
(211, 5, 10, 3, 4),
(212, 7, 13, 2, 2),
(213, 7, 14, 3, 3),
(214, 9, 17, 3, 3),
(215, 9, 18, 4, 4),
(216, 10, 19, 2, 2),
(217, 10, 20, 1, 1),
(218, 11, 21, 3, 3),
(219, 11, 22, 2, 2),
(220, 12, 23, 4, 4),
(221, 12, 24, 1, 1),
(222, 13, 25, 2, 2),
(223, 13, 26, 3, 3),
(224, 14, 27, 1, 1),
(225, 14, 28, 4, 4),
(226, 15, 29, 2, 2),
(227, 15, 30, 3, 3),
(228, 16, 31, 1, 1),
(229, 16, 32, 4, 4),
(230, 17, 33, 2, 2),
(231, 17, 34, 3, 3),
(232, 18, 35, 1, 1),
(233, 18, 36, 4, 4),
(234, 5, 45, 2, 2),
(235, 7, 47, 1, 1),
(236, 8, 48, 4, 4),
(237, 9, 49, 2, 2),
(238, 10, 50, 3, 3);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `listening`
--

CREATE TABLE `listening` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Zrzut danych tabeli `listening`
--

INSERT INTO `listening` (`id`, `name`, `answer`) VALUES
(1, '1snowfall.pm3', 'snow'),
(2, '2jessicas.mp3', 'jessica');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `words`
--

CREATE TABLE `words` (
  `id` int(11) NOT NULL,
  `pol` varchar(100) DEFAULT NULL,
  `ang` varchar(100) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Zrzut danych tabeli `words`
--

INSERT INTO `words` (`id`, `pol`, `ang`, `category_id`) VALUES
(1, 'Jabłko', 'Apple', 1),
(2, 'Chleb', 'Bread', 1),
(3, 'Ser', 'Cheese', 1),
(4, 'Kurczak', 'Chicken', 1),
(5, 'Ryba', 'Fish', 1),
(6, 'Winogrona', 'Grapes', 1),
(7, 'Cytryna', 'Lemon', 1),
(8, 'Mleko', 'Milk', 1),
(9, 'Pomarańcza', 'Orange', 1),
(10, 'Ziemniak', 'Potato', 1),
(11, 'Ryż', 'Rice', 1),
(12, 'Sałatka', 'Salad', 1),
(13, 'Zupa', 'Soup', 1),
(14, 'Stek', 'Steak', 1),
(15, 'Pomidor', 'Tomato', 1),
(16, 'Woda', 'Water', 1),
(17, 'Jogurt', 'Yogurt', 1),
(18, 'Masło', 'Butter', 1),
(19, 'Marchewka', 'Carrot', 1),
(20, 'Ciasto', 'Cake', 1),
(21, 'Koszykówka', 'Basketball', 2),
(22, 'Piłka nożna', 'Football', 2),
(23, 'Tenis', 'Tennis', 2),
(24, 'Pływanie', 'Swimming', 2),
(25, 'Bieganie', 'Running', 2),
(26, 'Kolarstwo', 'Cycling', 2),
(27, 'Narciarstwo', 'Skiing', 2),
(28, 'Siatkówka', 'Volleyball', 2),
(29, 'Boks', 'Boxing', 2),
(30, 'Golf', 'Golf', 2),
(31, 'Gimnastyka', 'Gymnastics', 2),
(32, 'Hokej', 'Hockey', 2),
(33, 'Rugby', 'Rugby', 2),
(34, 'Surfing', 'Surfing', 2),
(35, 'Baseball', 'Baseball', 2),
(36, 'Krykiet', 'Cricket', 2),
(37, 'Łyżwiarstwo', 'Skating', 2),
(38, 'Zapasy', 'Wrestling', 2),
(39, 'Wspinaczka', 'Climbing', 2),
(40, 'Wioślarstwo', 'Rowing', 2),
(41, 'Ramię', 'Arm', 3),
(42, 'Noga', 'Leg', 3),
(43, 'Głowa', 'Head', 3),
(44, 'Dłoń', 'Hand', 3),
(45, 'Stopa', 'Foot', 3),
(46, 'Oko', 'Eye', 3),
(47, 'Ucho', 'Ear', 3),
(48, 'Nos', 'Nose', 3),
(49, 'Usta', 'Mouth', 3),
(50, 'Zęby', 'Teeth', 3),
(51, 'Palec', 'Finger', 3),
(52, 'Palec u nogi', 'Toe', 3),
(53, 'Włosy', 'Hair', 3),
(54, 'Szyja', 'Neck', 3),
(55, 'Bark', 'Shoulder', 3),
(56, 'Kolano', 'Knee', 3),
(57, 'Łokieć', 'Elbow', 3),
(58, 'Plecy', 'Back', 3),
(59, 'Klatka piersiowa', 'Chest', 3),
(60, 'Brzuch', 'Stomach', 3),
(61, 'Lekarz', 'Doctor', 4),
(62, 'Nauczyciel', 'Teacher', 4),
(63, 'Inżynier', 'Engineer', 4),
(64, 'Pielęgniarka', 'Nurse', 4),
(65, 'Prawnik', 'Lawyer', 4),
(66, 'Szef kuchni', 'Chef', 4),
(67, 'Policjant', 'Police Officer', 4),
(68, 'Strażak', 'Firefighter', 4),
(69, 'Kierowca', 'Driver', 4),
(70, 'Mechanik', 'Mechanic', 4),
(71, 'Rolnik', 'Farmer', 4),
(72, 'Pilot', 'Pilot', 4),
(73, 'Żołnierz', 'Soldier', 4),
(74, 'Aktor', 'Actor', 4),
(75, 'Pisarz', 'Writer', 4),
(76, 'Artysta', 'Artist', 4),
(77, 'Naukowiec', 'Scientist', 4),
(78, 'Księgowy', 'Accountant', 4),
(79, 'Architekt', 'Architect', 4),
(80, 'Hydraulik', 'Plumber', 4);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `errors`
--
ALTER TABLE `errors`
  ADD PRIMARY KEY (`id`),
  ADD KEY `client_id` (`client_id`),
  ADD KEY `word_id` (`word_id`);

--
-- Indeksy dla tabeli `listening`
--
ALTER TABLE `listening`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `words`
--
ALTER TABLE `words`
  ADD PRIMARY KEY (`id`),
  ADD KEY `categoriesID` (`category_id`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT dla tabeli `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT dla tabeli `errors`
--
ALTER TABLE `errors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=239;

--
-- AUTO_INCREMENT dla tabeli `listening`
--
ALTER TABLE `listening`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT dla tabeli `words`
--
ALTER TABLE `words`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=81;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `errors`
--
ALTER TABLE `errors`
  ADD CONSTRAINT `errors_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `errors_ibfk_2` FOREIGN KEY (`word_id`) REFERENCES `words` (`id`);

--
-- Ograniczenia dla tabeli `words`
--
ALTER TABLE `words`
  ADD CONSTRAINT `words_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
