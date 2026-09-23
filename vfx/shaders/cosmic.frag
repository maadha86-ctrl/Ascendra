precision mediump float;uniform float uTime;varying vec2 vUv;
void main(){vec3 voidDeep=vec3(0.02,0.04,0.10);vec3 voidLight=vec3(0.04,0.06,0.13);vec3 nebula=vec3(0.29,0.49,1.0)*0.15*sin(vUv.y*3.0+uTime*0.1);vec3 earthGlow=vec3(0.16,0.36,0.66)*smoothstep(0.0,0.35,vUv.y)*0.45;vec3 finalCol=mix(voidDeep,voidLight,vUv.y)+nebula+earthGlow;gl_FragColor=vec4(finalCol,1.0);}
