const express=require('express');const cors=require('cors');const app=express();app.use(cors());app.use(express.json());
const universities=[
  {id:"SMU",name:"Sikkim Manipal University",country:"India",pattern:{theory:70,internal:30,pass:28,types:["MCQ","Short 5m","Long 10m"]}},
  {id:"VTU",name:"VTU",country:"India",pattern:{theory:100,pass:40,types:["MCQ","Short","Long"]}},
  {id:"MU",name:"Mumbai University",country:"India",pattern:{theory:80,internal:20,pass:32,types:["MCQ","Short","Long"]}},
  {id:"DU",name:"Delhi University",country:"India",pattern:{theory:75,internal:25,pass:30,types:["MCQ","Short","Long"]}},
  {id:"【entity-MIT¦canonical_name=MIT】",name:"【entity-MIT¦canonical_name=MIT】",country:"USA",pattern:{gpa:"5",types:["Problem Set","Project"]}},
  {id:"【entity-STANFORD¦canonical_name=Stanford University】",name:"【entity-Stanford¦canonical_name=Stanford University】",country:"USA",pattern:{gpa:"4",types:["Assignment","Midterm"]}},
  {id:"【entity-OXFORD¦canonical_name=Oxford】",name:"【entity-Oxford¦canonical_name=Oxford】",country:"UK",pattern:{honours:"First-2:1",types:["Essay","Tutorial"]}},
  {id:"CUSTOM",name:"Other",country:"Global",pattern:{theory:70,internal:30,pass:28,types:["MCQ","Short","Long"]}}
];
app.get('/',(req,res)=>res.json({app:"Ascendra AI GLOBAL",version:"2.0",global:true,universities:universities.length,message:"ANY university worldwide 100% result",engines:["Global Syllabus","Adaptive Exam Pattern","AI Tutor + PYQ","100% Prep"]}));
app.get('/api/universities',(req,res)=>res.json(universities));
app.get('/api/syllabus/:universityId/:program/:year',(req,res)=>{
  const uni=universities.find(u=>u.id===req.params.universityId) || universities[universities.length-1];
  res.json({university:uni,tree:`${uni.country}->${uni.name}->${req.params.program}->${req.params.year}`,prep:`PYQ 10y + Important + ${uni.pattern.theory||'GPA'} marks`});
});
app.post('/api/ai/tutor',(req,res)=>{
  const {query,subject,universityId} = req.body;
  const uni=universities.find(u=>u.id===universityId) || universities[0];
  res.json({response:`GLOBAL AI [${uni.name} ${subject}]: ${query} - Adapted to ${uni.country} (${uni.pattern.types}) for 100% result [LIVE]`});
});
app.listen(3000,()=>console.log('GLOBAL Backend LIVE - ANY University'));
