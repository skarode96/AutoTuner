export class Accessories {

    tyres:string;
    paintJob:string;
    engine:string;
    music:string;
    brakes:string;
    headLights:string;
    wheels:string;
    sideMirrors:string;


    constructor(tyres: string, paintJob: string, engine: string, music: string, brakes:string, headLights:string, wheels:string, sideMirrors:string) {
        this.tyres = tyres;
        this.paintJob = paintJob;
        this.engine = engine;
        this.music = music;
        this.brakes = brakes;
        this.headLights = headLights;
        this.wheels = wheels;
        this.sideMirrors = sideMirrors;
    }
}