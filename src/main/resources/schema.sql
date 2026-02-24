CREATE TABLE IF NOT EXISTS customer (
  customer_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  mobile_number VARCHAR(20) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  created_by VARCHAR(50) NOT NULL,
  updated_at TIMESTAMP NULL,
  updated_by VARCHAR(50) NULL
);

CREATE TABLE IF NOT EXISTS accounts (
  account_number BIGINT AUTO_INCREMENT PRIMARY KEY,
  customer_id BIGINT NOT NULL,
  account_type VARCHAR(100) NOT NULL,
  branch_address VARCHAR(200) NOT NULL,
  opened_date DATE NOT NULL,
  status VARCHAR(20) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  created_by VARCHAR(50) NOT NULL,
  updated_at TIMESTAMP NULL,
  updated_by VARCHAR(50) NULL,
  CONSTRAINT fk_accounts_customer FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);
