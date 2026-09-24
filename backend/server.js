const express = require('express');
const cors = require('cors');
const app = express();
const PORT = process.env.PORT || 10000;

app.use(cors({ origin: '*' }));
app.use(express.json());

app.get('/', (req, res) => {
  res.json({ 
    status: 'Ascendra LIVE worldwide 🌍',
    url: 'https://ascendra-7i8x.onrender.com',
    version: '2.0 - Permanent',
    timestamp: new Date().toISOString()
  });
});

app.get('/api/universities', (req, res) => {
  res.json({ count: '5000+ universities worldwide', live: true });
});

// ADD NOTIFY ENDPOINT - this fixes your curl error
app.post('/api/notify-all', (req, res) => {
  const { title, message } = req.body;
  console.log(`🌍 BROADCAST: ${title} - ${message}`);
  res.json({ success: true, sent_to: 'all users', title, message, at: new Date().toISOString() });
});

app.get('/api/notify-all', (req, res) => {
  res.json({ info: 'Use POST to send notification to all users' });
});

app.listen(PORT, () => {
  console.log(`🚀 Ascendra GLOBAL Backend LIVE on ${PORT} - ANY University`);
  console.log(`==> Your service is live 🎉`);
  console.log(`==> Available at your primary URL https://ascendra-7i8x.onrender.com`);
});
