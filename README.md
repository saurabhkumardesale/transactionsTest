# Online Banking Miniatures–Backend Service
Branch for showing transactions history


DB Schema: 

TABLE transactions (
    txn_id UUID PRIMARY KEY NOT NULL,
    from_acc VARCHAR(64) NOT NULL,
    to_acc  VARCHAR(64)  NOT NULL,
    amount DOUBLE PRECISION NOT NULL,
    time TIMESTAMP NOT NULL,
    label VARCHAR(150) NOT NULL,
    status VARCHAR(150) NOT NULL       
);
