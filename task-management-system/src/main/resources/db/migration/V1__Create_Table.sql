
CREATE TABLE IF NOT EXISTS users(
   id SERIAL PRIMARY KEY,
   first_name VARCHAR(256) NOT NULL,
   last_name VARCHAR(256) NOT NULL,
   email VARCHAR(256) NOT NULL,
   password VARCHAR(2048) NOT NULL,
   user_role VARCHAR(50) NOT NULL

);

CREATE TABLE IF NOT EXISTS tasks (
    id SERIAL PRIMARY KEY,
    header VARCHAR(255) NOT NULL,
    description TEXT,
    task_status VARCHAR(50) NOT NULL,
    task_priority VARCHAR(50) NOT NULL,
    comments TEXT,
    user_id_author BIGINT NOT NULL,
    user_id_executor BIGINT NOT NULL,

    FOREIGN KEY (user_id_author) REFERENCES users(id),
    FOREIGN KEY (user_id_executor) REFERENCES users(id)
);