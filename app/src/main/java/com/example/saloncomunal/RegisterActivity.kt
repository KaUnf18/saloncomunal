package com.example.saloncomunal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var rgUserType: RadioGroup
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Inicializar las vistas
        etName = findViewById(R.id.et_name)
        etEmail = findViewById(R.id.et_email)
        rgUserType = findViewById(R.id.rg_user_type)
        btnRegister = findViewById(R.id.btn_register)

        // Configurar el clic del botón de registro
        btnRegister.setOnClickListener {
            // Obtener los valores ingresados
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()

            // Verificar si los campos están vacíos
            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Obtener el tipo de usuario seleccionado
            val selectedUserTypeId = rgUserType.checkedRadioButtonId
            val userType = if (selectedUserTypeId != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedUserTypeId)
                selectedRadioButton.text.toString()
            } else {
                null
            }

            if (userType == null) {
                Toast.makeText(this, "Por favor, seleccione un tipo de usuario", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Enviar los datos a la siguiente pantalla o procesarlos
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("USER_NAME", name)
            intent.putExtra("USER_EMAIL", email)
            intent.putExtra("USER_TYPE", userType)
            startActivity(intent)

            // Opcional: Mostrar un mensaje de éxito
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
            finish()  // Cerrar la actividad de registro después de completar
        }
    }
}