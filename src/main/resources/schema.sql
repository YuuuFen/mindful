CREATE TABLE IF NOT EXISTS activity (
        id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
--     description TEXT,
    duration_minutes INTEGER NOT NULL,
    date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    mood_rating INTEGER CHECK (mood_rating BETWEEN 1 AND 5)
);

CREATE TABLE IF NOT EXISTS feeling (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS activity_feeling (
    activity_id UUID REFERENCES activity(id) ON DELETE CASCADE,
    feeling_id BIGINT REFERENCES feeling(id) ON DELETE CASCADE,
    PRIMARY KEY (activity_id, feeling_id)
);
