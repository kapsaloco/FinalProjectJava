import classes from "./PersonApi.module.css"
import { useRef } from "react";
import 'react-phone-number-input/style.css'
import PhoneInput from 'react-phone-number-input'
import { useState } from 'react';

function PersonApi() {

  const [valueNum, setValue] = useState()

  const firstnameRef = useRef();
  const lastnameRef = useRef();
  const phonenumberRef = useRef();
  const emailRef = useRef();

  function submitHandler(event) {
    event.preventDefault();

    const enteredFirstName = firstnameRef.current.value;
    const enteredLastName = lastnameRef.current.value;
    const enteredPhoneNumber = phonenumberRef.current.value;
    const enteredEmail = emailRef.current.value;

    const formData = {
      firstname: enteredFirstName,
      lastname: enteredLastName,
      phoneNumber: enteredPhoneNumber,
      email: enteredEmail,
    };
    
    console.log(formData)
    fetch("http://localhost:8080/api/person",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(formData)

  }).then((data)=>{
    console.log("New Person Added")
    // window.location.assign("http://localhost:3000/Login#s=1");
  })
    //function to handle the inputted data (will be used on API)
    // props.onAddMeetup(meetupData);
  }

  return (
    <div className={classes.row} id="Set">

      <div className={classes.column}>
        <div className={classes.formContainer}>
        <form className={classes.form} onSubmit={submitHandler}>
        <div className={classes.control}>
          <label htmlFor="firstname">First Name</label>
          <input type="text" required id="firstname" ref={firstnameRef} />
        </div>
        <div className={classes.control}>
          <label htmlFor="lastname">Last Name</label>
          <input type="text" required id="lastname" ref={lastnameRef} />
        </div>
        <div className={classes.control}>
        <label htmlFor="address">Phone Number</label>
            <PhoneInput
          placeholder="Enter phone number"
          value={valueNum}
          ref={phonenumberRef}
          onChange={setValue}
          style={{width: "71%", marginLeft: "48px"}}
         />
          
          {/* <input type="text" required id="number" ref={phonenumberRef} /> */}
        </div>
        <div className={classes.control}>
          <label htmlFor="description">E-mail</label>
          <input type="text" required id="email" ref={emailRef} />
        </div>

        <div className={classes.actions}>
          <button>Add Person</button>
        </div>
      </form>
        </div>
      </div>
      
      <div className={classes.column}></div>
    </div>
  );
}
export default PersonApi;
