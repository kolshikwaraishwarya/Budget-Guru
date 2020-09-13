const functions = require('firebase-functions')    
const admin = require('firebase-admin');

require('dotenv').config();

const nodemailer = require('nodemailer');
const cron = require('node-cron');
let transporter = nodemailer.createTransport({
    service: 'gmail',
    auth: {
        user: process.env.EMAIL,
        pass: process.env.PASSWORD,
    }
});
let mailOptions = {
    from: 'fmail1476@gmail.com',
    to: 'snehagumudavelly@gmail.com',
    subject: 'Hope this works',
    text: 'Hello'
};
cron.schedule('1,2 * * * * *',()=>{             
    transporter.sendMail(mailOptions, function(err, data){
    if(err){
        console.log('Errorrrr',err);
    }else{
        console.log('Email Sent');
    }
    }); 
}
)