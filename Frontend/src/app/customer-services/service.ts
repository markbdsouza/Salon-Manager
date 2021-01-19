export class Service {
  constructor(
    public serviceTypeId: string,
    public serviceType: string,
    public name: string,
    public description: string,
    public summary: string,
    public serviceCost: number,
    public taxCost: number,
    public estimatedMinutes: number
  ) {}
}
