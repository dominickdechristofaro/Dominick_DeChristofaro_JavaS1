-- SELECT * FROM game_store.processing_fee;
-- SET SQL_SAFE_UPDATES = 0;
-- DELETE FROM processing_fee;
-- SET SQL_SAFE_UPDATES = 1;
INSERT INTO processing_fee (product_type, fee) VALUES ("Console", 14.99);
INSERT INTO processing_fee (product_type, fee) VALUES ("T-Shirt", 1.98);
INSERT INTO processing_fee (product_type, fee) VALUES ("Game", 1.49);