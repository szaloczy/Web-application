export interface RegisterDTO {
    username: string;
    email: string;
    password: string;
}

export interface LoginDTO {
    email: string;
    password: string;
}

export interface AccessTokenDTO {
    token: string;
    username: string;
    email: string;
    role: string;
}

export interface LocationDTO {
    id?: number;
    name: string;
    address: string;
    status: LocationStatus;
}

export enum LocationStatus {
    ACTIVE = 'ACTIVE',
    INACTIVE = 'INACTIVE'
}

export interface UserDTO {
    id: number;
    username: string;
    email: string;
    role: string;
}

export interface ClientDTO {
    id?: number;
    fullname: string;
    birthplace: string;
    date_of_birth: Date;
    citizenship: string;
    address: string;
    taj_number: string;
    gender: GenderType;
}

export interface DonationDTO {
    id?: number;
    date: Date | string;
    eligible: boolean;
    reason: string | null;
    doctor: string;
    controlled: boolean;
    patientFullname: string | null;
    patientTaj: string | null;
    clientId: number;
    locationId: number;
    client: ClientDTO;
    location: LocationDTO;
}

export interface DonationCreateDTO {
    date: Date | string;
    eligible: boolean;
    reason: string | null;
    doctor: string;
    controlled: boolean;
    patient_fullname: string | null;
    patient_taj: string | null;
    client: number;
    location: number;
}

export enum GenderType {
    MALE = 'MALE',
    FEMALE = 'FEMALE'
}