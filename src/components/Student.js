import ButtonActionGroup from "./ButtonActionGroup";

export default function Student({ info }) {
  const { firstName, lastName, email } = info;

  return (
    <tr>
      <td>{firstName}</td>
      <td>{lastName}</td>
      <td>{email}</td>
      <td>
        <ButtonActionGroup info={info} />
      </td>
    </tr>
  );
}
