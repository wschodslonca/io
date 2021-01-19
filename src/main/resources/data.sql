INSERT INTO public.cars(
    car_id, drive, fuel, horsepower, model, photo_path, price, promo_ratio, seats, status, transmission, short_description)
VALUES (1, 'Manual', 'Petrol', 69, 'Fiat Panda', './../assets/panda.jpg', 50.0, 1.0, 5, 'Available', 'FWD', '');
INSERT INTO public.cars(
    car_id, drive, fuel, horsepower, model, photo_path, price, promo_ratio, seats, status, transmission, short_description)
VALUES (2, 'Manual', 'Petrol', 72, 'Toyota Aygo', './../assets/aygo.jpg', 45.0, 1.0, 5, 'Available', 'FWD', '');
INSERT INTO public.cars(
    car_id, drive, fuel, horsepower, model, photo_path, price, promo_ratio, seats, status, transmission, short_description)
VALUES (3, 'Manual', 'Petrol', 120, 'Kia Rio', './../assets/rio.jpg', 55.0, 1.0, 5, 'Available', 'FWD', '');
INSERT INTO public.cars(
    car_id, drive, fuel, horsepower, model, photo_path, price, promo_ratio, seats, status, transmission, short_description)
VALUES (4, 'Manual', 'Petrol', 99, 'Toyota Yaris', './../assets/yaris.jpg', 50.0, 1.0, 5, 'Available', 'FWD', '');
INSERT INTO public.cars(
    car_id, drive, fuel, horsepower, model, photo_path, price, promo_ratio, seats, status, transmission, short_description)
VALUES (5, 'Automatic', 'Diesel', 340, 'BMW Series 5', './../assets/series5.jpg', 100.0, 1.0, 5, 'Available', 'RWD', '');
INSERT INTO public.cars(
    car_id, drive, fuel, horsepower, model, photo_path, price, promo_ratio, seats, status, transmission, short_description)
VALUES (6, 'Manual', 'Petrol', 160, 'Renault Megane', './../assets/megane.jpg', 60.0, 1.0, 5, 'Available', 'FWD', '');
INSERT INTO public.cars(
    car_id, drive, fuel, horsepower, model, photo_path, price, promo_ratio, seats, status, transmission, short_description)
VALUES (7, 'Manual', 'Petrol', 110, 'Hyundai i30', './../assets/i30.jpg', 50.0, 1.0, 5, 'Available', 'FWD', '');
INSERT INTO public.cars(
    car_id, drive, fuel, horsepower, model, photo_path, price, promo_ratio, seats, status, transmission, short_description)
VALUES (8, 'Automatic', 'Petrol', 374, 'BMW Series 3', './../assets/series3.jpg', 90.0, 1.0, 5, 'Available', '4WD', '');
INSERT INTO public.cars(
    car_id, drive, fuel, horsepower, model, photo_path, price, promo_ratio, seats, status, transmission, short_description)
VALUES (9, 'Manual', 'Diesel', 190, 'Audi A4', './../assets/a4.jpg',65.0, 1.0, 5, 'Available', '4WD', '');
INSERT INTO public.cars(
    car_id, drive, fuel, horsepower, model, photo_path, price, promo_ratio, seats, status, transmission, short_description)
VALUES (10, 'Automatic', 'Petrol', 390, 'Mercedes-Benz C-Class', './../assets/cClass.jpg', 80.0, 1.0, 4, 'Available', '4WD', '');
INSERT INTO public.cars(
    car_id, drive, fuel, horsepower, model, photo_path, price, promo_ratio, seats, status, transmission, short_description)
VALUES (11, 'Automatic', 'Petrol', 366, 'Kia Stinger', './../assets/stinger.jpg', 75.0, 1.0, 5, 'Available', '4WD', '');
INSERT INTO public.cars(
    car_id, drive, fuel, horsepower, model, photo_path, price, promo_ratio, seats, status, transmission, short_description)
VALUES (12, 'Automatic', 'Petrol', 242, 'Ford Escape', './../assets/escape.jpg', 55.0, 1.0, 5, 'Available', '4WD', '');
INSERT INTO public.cars(
    car_id, drive, fuel, horsepower, model, photo_path, price, promo_ratio, seats, status, transmission, short_description)
VALUES (13, 'Automatic', 'Diesel', 231, 'BMW X5', './../assets/x5.jpg', 80.0, 1.0, 5, 'Available', '4WD', '');
INSERT INTO public.cars(
    car_id, drive, fuel, horsepower, model, photo_path, price, promo_ratio, seats, status, transmission, short_description)
VALUES (14, 'Automatic', 'Petrol', 680, 'Porsche Panamera', './../assets/panamera.jpg', 95.0, 1.0, 5, 'Available', '4WD', '');
INSERT INTO public.cars(
    car_id, drive, fuel, horsepower, model, photo_path, price, promo_ratio, seats, status, transmission, short_description)
VALUES (15, 'Automatic', 'Petrol', 650, 'Lamborghini Urus', './../assets/urus.jpg', 95.0, 1.0, 5, 'Available', '4WD', '');

INSERT INTO public.users(
    user_id, address, birth_date, discount_ratio, email, inf_promo, is_banned, name, passwd, surname, tel, total_payed)
VALUES (1, '7 Tennyson Alley', '1981-01-25',1.0, 'darendsen0@fc2.com', TRUE, FALSE, 'Dolph', 'swGcvqso', 'Arendsen', '7837056994', 612.0);
INSERT INTO public.users(
    user_id, address, birth_date, discount_ratio, email, inf_promo, is_banned, name, passwd, surname, tel, total_payed)
VALUES (2, '72 Riverside Street', '1977-08-04', 1.2, 'tdjurisic1@sakura.ne.jp', TRUE, FALSE, 'Tybalt', 'JF71U1UE', 'Djurisic', '472357126', 2045.0);
INSERT INTO public.users(
    user_id, address, birth_date, discount_ratio, email, inf_promo, is_banned, name, passwd, surname, tel, total_payed)
VALUES (3, '64876 Banding Parkway', '1966-11-25', 1.1, 'agever2@flavors.me', FALSE, FALSE, 'Arda', '42i3XdoiFPcC', 'Gever', 701159211, 1360.0);

INSERT INTO public.service_tech(
    service_tech_id, email, passwd)
VALUES (1, 'lossantos_customs@gmail.com', 'police0');
INSERT INTO public.service_tech(
    service_tech_id, email, passwd)
VALUES (2, 'alabamacars@carservice.us', 'lenny123');
INSERT INTO public.service_tech(
    service_tech_id, email, passwd)
VALUES (3, 'casey_vehicles@csd.us', 'potato6');

INSERT INTO public.admins(
    admin_id, email, passwd)
VALUES (1, 'admin@wypochodzik.pl', 'papiez');