import React, {useEffect, useState} from "react"

/**
 * This component should show some information about a Star Wars character.
 * @returns {*}
 * @constructor
 */
const MyComponent = () => {
    const [person, setPerson] = useState({
        name: '',
        birthYear: '',
        eyeColor: '',
        gender: '',
        hairColor: '',
        mass: '',
        height: '',
        homeworld: '',
        skinColor: '',
        created: '',
    });
    const axios = require('axios');
    const getRandomPerson = async () => {
        let requestPerson = {};

        await axios.get('http://localhost:8080/api/v1/sw/characters/random')
            .then(function (response) {
                requestPerson = response.data;
                console.log(response);
                console.log('requestPerson', requestPerson);

            })
            .catch(function (error) {
                // handle error
                console.log(error);

                return {}
            });

        return requestPerson;
    };

    useEffect(() => {
        //Call spring back-end
        getRandomPerson().then((v) => {
            console.log('v', v)
            setPerson(v)
        })
    }, []);

    return <div>
        <div>
            Name: {person.name || ''} <br/>
            Birth Year: {person.birthYear || ''} <br/>
            Eye Color: {person.eyeColor || ''} <br/>
            Gender: {person.gender || ''} <br/>
            Hair Color: {person.hairColor || ''} <br/>
            Height: {person.height || ''} <br/>
            Mass: {person.mass || ''} <br/>
            Skin Color: {person.skinColor || ''} <br/>
            Homeworld: {person.homeworld || ''} <br/>
            Created: {person.created || ''} <br/>
        </div>

        <button onClick={() => getRandomPerson().then((v) => setPerson(v))}>I want yoda!</button>
    </div>
};

export default MyComponent
